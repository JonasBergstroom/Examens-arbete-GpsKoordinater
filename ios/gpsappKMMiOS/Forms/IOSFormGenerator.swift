import AVFoundation
import AVKit
import Foundation
import shared
import UIKit
import MapKit

class IOSFormGenerator: FormGenerator {
    private var mainView = UIStackView()
    private var currentScreenRendered: Int32 = 0

    var presentingViewController: UIViewController?

    init() {
        mainView.axis = .vertical
        mainView.distribution = .fillProportionally
    }

    func updateInterface(components: [FormComponent], currentScreen: Int32) {
        if currentScreen != currentScreenRendered {
            presentingViewController?.children.forEach { child in
                child.willMove(toParent: nil)
                child.removeFromParent()
            }
            mainView.subviews.forEach { $0.removeFromSuperview() }
            currentScreenRendered = currentScreen
        }

        generateInterface(components: components, currentScreen: currentScreen.asKotlinInt)
    }

    func createInterface(components: [FormComponent], currentScreen: Int32) -> Any {
        generateInterface(components: components, currentScreen: currentScreen.asKotlinInt)

        return mainView
    }

    func generateInterface(components: [FormComponent], currentScreen: KotlinInt?) {
        guard let currentScreen = currentScreen else { return }
        let screenTag = Int(truncating: currentScreen)

        for component in components {
            switch component.type {
            case .body:
                if let body = component as? FormComponentText {
                    mainView.createBodyLabel(screenTag: screenTag, text: body.text)
                }
            case .titlebig:
                if let title = component as? FormComponentText {
                    mainView.addBigTitleLabel(screenTag: screenTag, text: title.text)
                }
            case .titlesmall:
                if let title = component as? FormComponentText {
                    mainView.addSmallTitleLabel(screenTag: screenTag, text: title.text)
                }
            case .image:
                if let image = component as? FormComponentImage {
                    mainView.addImage(imageName: image.image, caption: image.caption)
                }
            case .maps:
                if let mapImage = component as? FormComponentMap {
                    addMap(screenTag: screenTag, id: mapImage.id)
                }
            default:
                print("unknown component")
            }
        }
    }
}

private extension IOSFormGenerator {
    
    func addMap(screenTag: Int, id: String) {
        let mapViewController = MapScreenViewController()
        
        mainView.addArrangedSubview(mapViewController.view)
        presentingViewController?.addChild(mapViewController)
        mapViewController.didMove(toParent: presentingViewController)
        
        mapViewController.view.translatesAutoresizingMaskIntoConstraints = false
        mapViewController.view.heightAnchor.constraint(equalTo: mapViewController.view.widthAnchor).isActive = true
    }
}

extension UIStackView {
    func addImage(imageName: String, caption: String) {
        var verticalSpace = getVerticalSpacingView(withHeight: 20)
        self.addArrangedSubview(verticalSpace)

        let imageView = UIImageView()
        let stackView = UIStackView()
        self.addArrangedSubview(stackView)

        imageView.image = UIImage(named: imageName)
        imageView.widthAnchor.constraint(equalToConstant: 250).isActive = true
        imageView.heightAnchor.constraint(equalToConstant: 250).isActive = true
        imageView.contentMode = .scaleAspectFit
        let label = getDefaultLabel()
        label.text = caption
        label.font = UIFont.scaledFont(name: UIFont.fontNameRegular, textStyle: .callout)
        label.textAlignment = .left

        stackView.addArrangedSubview(imageView)
        verticalSpace = getVerticalSpacingView(withHeight: 10)
        self.addArrangedSubview(verticalSpace)
        self.addArrangedSubview(label)
    }
    
    func addGridImages(id: String,names:String,captions:String) -> UIStackView{
        let imageStackView = UIStackView()
        imageStackView.axis = .vertical
        imageStackView.distribution = .fillEqually
        imageStackView.alignment = .center
        imageStackView.spacing = 5
        imageStackView.translatesAutoresizingMaskIntoConstraints = false
        
        let imageView = UIImageView()
        imageView.image = UIImage(named: names)
        imageView.contentMode = .scaleAspectFit
        imageView.frame.size = CGSize(width: 10, height: 10)
        
        let captionStackView = UIStackView()
        captionStackView.axis = .vertical
        captionStackView.distribution = .fillEqually
        captionStackView.alignment = .center
        captionStackView.spacing = 5
        captionStackView.translatesAutoresizingMaskIntoConstraints = false
        
        let label = UILabel()
        label.text = captions
        captionStackView.addArrangedSubview(label)
        
        let verticalSpace = getVerticalSpacingView(withHeight: 50)
        
        imageStackView.addArrangedSubview(verticalSpace)
        imageStackView.addArrangedSubview(imageView)
        imageStackView.addArrangedSubview(captionStackView)
        
        return imageStackView
    }
    
    
    

    func addBigTitleLabel(screenTag: Int,text: String) {
        if self.subviews.first(where: { view in view.tag == screenTag }) == nil {
            let label = getDefaultLabel()
            label.text = text
            label.font = UIFont.scaledFont(name: UIFont.fontNameBold, textStyle: .title2)
            label.textColor =  UIColor.gpsapp.labelTitleColor

            self.addArrangedSubview(label)
        }
    }

    func addSmallTitleLabel(screenTag: Int,text: String) {
        if self.subviews.first(where: { view in view.tag == screenTag }) == nil {
            let verticalSpacing = getVerticalSpacingView(withHeight: 20)
            self.addArrangedSubview(verticalSpacing)

            let label = getDefaultLabel()
            label.text = text
            label.textColor =  UIColor.gpsapp.labelTitleColor
            label.font = UIFont.scaledFont(name: UIFont.fontNameBold, textStyle: .body)
            
            self.addArrangedSubview(label)
        }
    }

    func createBodyLabel(screenTag: Int, text: String) {
        if self.subviews.first(where: { view in view.tag == screenTag }) == nil {
            let verticalSpacing = getVerticalSpacingView(withHeight: 10)
            self.addArrangedSubview(verticalSpacing)

            let stackView = UIStackView()
            stackView.axis = .vertical
            self.addArrangedSubview(stackView)
            let label = getDefaultLabel()
            label.tag = screenTag
            label.text = text
            label.font = UIFont.scaledFont(name: UIFont.fontNameRegular, textStyle: .body)
            
            stackView.addArrangedSubview(label)
        }
    }

    func getDefaultLabel() -> UILabel {
        let label = UILabel()
        label.numberOfLines = 0
        label.lineBreakMode = .byWordWrapping
        label.adjustsFontForContentSizeCategory = true
        label.textColor = UIColor.gpsapp.defaultTextColor

        return label
    }

    func getVerticalSpacingView(withHeight height: CGFloat) -> UIView {
        let view = UIView()
        view.translatesAutoresizingMaskIntoConstraints = false
        view.heightAnchor.constraint(equalToConstant: height).isActive = true

        return view
    }
}
