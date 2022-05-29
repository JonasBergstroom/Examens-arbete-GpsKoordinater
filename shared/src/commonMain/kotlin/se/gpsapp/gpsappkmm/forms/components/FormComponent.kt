package se.gpsappkmm.gpsappkmm.forms.components

enum class ComponentType {
    TITLEBIG,
    TITLESMALL,
    BODY,
    IMAGE,
    EMPTYLINE,
}

interface FormComponent {
    val type: ComponentType
    val id: String
}

class FormComponentText(
    override val type: ComponentType,
    override val id: String,
    val text: String
) :
    FormComponent

class FormComponentImage(
    override val type: ComponentType,
    override val id: String,
    val image: String,
    val caption: String,
) : FormComponent

class FormComponentLine(
    override val type: ComponentType,
    override val id: String,
    val text: String
) : FormComponent


