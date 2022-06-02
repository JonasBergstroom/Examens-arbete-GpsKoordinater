import UIKit
import shared

final class StartScreenViewController: UIViewController {

    @IBOutlet private weak var welcomelabel: UILabel!
    @IBOutlet private weak var appnamelabel: UILabel!
    @IBOutlet private weak var aboutlabel: UILabel!
    @IBOutlet private weak var newtestlabel: UILabel!

    override func viewDidLoad() {
        super.viewDidLoad()

    }
    
    @IBAction func toStartMenu(_ sender: Any) {
        navigationController?.pushViewController(StartMenuViewController(), animated: true)
    }
    

}
