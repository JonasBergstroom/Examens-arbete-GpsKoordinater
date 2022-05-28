package se.gpsappkmm.gpsappkmm.android.forms

import android.content.Context
import android.view.*
import android.widget.*
import se.gpsappkmm.gpsappkmm.android.MainApplication
import se.gpsappkmm.gpsappkmm.android.databinding.*
import se.gpsappkmm.gpsappkmm.forms.components.*

class AndroidFormGenerator(context: Context) :
    FormGenerator {
    private var mainView: LinearLayout = LinearLayout(context).also {
        val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(40, 0, 40, 0)
        it.layoutParams = params
        it.orientation = LinearLayout.VERTICAL
    }
    private var currentScreenRendered: Int = 0

    override fun generateInterface(components: List<FormComponent>, currentScreen: Int?) {
        for (component in components) {
            when (component.type) {
                ComponentType.TITLEBIG -> {
                    val bigTitle = (component as FormComponentText)
                    mainView.createOrUpdateBigTitleLabel(bigTitle.text, bigTitle.id)
                }
                ComponentType.TITLESMALL -> {
                    val smallTitle = (component as FormComponentText)
                    mainView.createOrUpdateSmallTitleLabel(smallTitle.text, smallTitle.id)
                }
                ComponentType.BODY -> {
                    val body = (component as FormComponentText)
                    mainView.createOrUpdateBodyLabel(body.text, body.id)
                }
                ComponentType.IMAGE -> {
                    val image = (component as FormComponentImage)
                    mainView.createOrUpdateImage(image.id, image.image, image.caption)
                }
                else -> println("unknown")
            }
        }
    }

    fun createInterface(components: List<FormComponent>): View {
        generateInterface(components)

        return mainView
    }

    fun updateInterface(components: List<FormComponent>, currentScreen: Int) {
        if (currentScreen != currentScreenRendered) {
            mainView.removeAllViews()
            currentScreenRendered = currentScreen
        }
        generateInterface(components)
    }
}

private fun ViewGroup.createOrUpdateBigTitleLabel(text: String, id: String) {
    val binding: FormBigTitleLabelBinding =
        FormBigTitleLabelBinding.inflate(LayoutInflater.from(context))
    this.findViewWithTag(id) ?: binding.formBigTitleLabelContainer.rootView.apply { tag = id }
        .also { this.addView(it) }
    binding.bigTitleLabelTextview.text = text
}

private fun ViewGroup.createOrUpdateSmallTitleLabel(text: String, id: String) {
    val binding: FormSmallTitleLabelBinding =
        FormSmallTitleLabelBinding.inflate(LayoutInflater.from(context))

    this.findViewWithTag(id) ?: binding.formSmallTitleLabelContainer.rootView.apply { tag = id }
        .also { this.addView(it) }
    binding.title.text = text
}

private fun ViewGroup.createOrUpdateBodyLabel(text: String, id: String) {
    val binding: FormBodyLabelBinding = FormBodyLabelBinding.inflate(LayoutInflater.from(context))
    this.findViewWithTag(id) ?: binding.formBodyLabelContainer.rootView.apply { tag = id }
        .also { this.addView(it) }
    binding.bodyLabelTextview.text = text
}


private fun ViewGroup.createOrUpdateImage(id: String, imageName: String, caption: String) {
    val binding: FormImageBinding = FormImageBinding.inflate(LayoutInflater.from(context))

    this.findViewWithTag(id) ?: binding.formImageviewContainer.rootView.apply { tag = id }
        .also { this.addView(it) }

    binding.imageview.setImageResource(getImageResource(imageName))
    binding.textView.text = caption
}

private fun ViewGroup.getImageResource(name: String): Int {
    return context.resources.getIdentifier("drawable/$name", null, context.packageName)
}

private fun ViewGroup.getApplication(): MainApplication {
    return context.applicationContext as MainApplication
}