import shared

class IOSFormViewModel {
    static let shared = IOSFormViewModel()
    
    var formViewModel = FormViewModel(form: FormFactory().createForm(type: FormType.start))
    
    func changeForm(toType type: FormType) {
        switch (type) {
        case FormType.start:
            formViewModel = FormViewModel(form: FormFactory().createForm(type: FormType.start))

        default:
            return
        }
    }
}
