import shared
import UIKit

class StartMenuViewController: UIViewController {


  
    @IBOutlet weak var start_menu_titlecontainer: DynamicLabel!
    @IBOutlet weak var start_menu_textcontainer: DynamicLabel!
    @IBOutlet weak var start_menu_infolabel: DynamicLabel!
    @IBOutlet weak var start_menu_infotext: DynamicLabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        setupLabels()
    }
    
    private func setupLabels() {
        let smallTitles = [start_menu_titlecontainer]
        let bigTitles = [start_menu_textcontainer]
        smallTitles.forEach {
            $0?.font = UIFont.scaledFont(name: UIFont.fontNameRegular, textStyle: .caption1)
        }
        bigTitles.forEach {
            $0?.font = UIFont.scaledFont(name: UIFont.fontNameBold, textStyle: .body)
        }
        
        start_menu_infolabel.font = UIFont.scaledFont(name: UIFont.fontNameBold, textStyle: .body)
        start_menu_infotext.font = UIFont.scaledFont(name: UIFont.fontNameRegular, textStyle: .body)
        
 
    }
    
    @IBAction func startGpsApp(_ sender: Any) {
        navigationController?.pushViewController(FormViewController(), animated: true)
        
    }
    
    
}
