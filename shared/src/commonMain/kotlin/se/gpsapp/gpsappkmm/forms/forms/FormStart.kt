package se.gpsapp.gpsappkmm.forms.forms

import se.gpsapp.gpsappkmm.forms.models.FormData
import se.gpsapp.gpsappkmm.forms.models.FormDataStart
import se.gpsappkmm.gpsappkmm.forms.components.*
import se.gpsappkmm.gpsappkmm.forms.forms.Form
import se.gpsappkmm.gpsappkmm.forms.forms.FormType


data class FormStart(
    override val type: FormType = FormType.Start,
    override val data: FormData = FormDataStart(),
) : Form {
    override val screens: List<FormScreen> = listOf(
        FormScreen
            (
            components = listOf<FormComponent>(
                FormComponentText(
                    id = "inledningBodyScreen1",
                    type = ComponentType.BODY,
                    text = "Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, graphic or web designs. The passage is attributed to an unknown typesetter in the 15th century who is thought to have scrambled parts of Cicero\\'s De Finibus Bonorum et Malorum for use in a type specimen book. It usually begins with:\n" +
                            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
                ),
                FormComponentImage(
                    id = "GpsImageScreen1",
                    type = ComponentType.IMAGE,
                    caption = "Foto från....",
                    image = "startscreen_gps"
                ),
            ),
        ),
        FormScreen(
            components = listOf<FormComponent>(
                FormComponentText(
                    id = "historiaTitleScreen2",
                    type = ComponentType.TITLESMALL,
                    text = "Historia"
                ),
                FormComponentText(
                    id = "historiaBodyScreen2",
                    type = ComponentType.BODY,
                    text = "Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, graphic or web designs. The passage is attributed to an unknown typesetter in the 15th century who is thought to have scrambled parts of Cicero\\'s De Finibus Bonorum et Malorum for use in a type specimen book. It usually begins with:\n" +
                            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
                ),
                FormComponentImage(
                    id = "GpsImageScreen2",
                    type = ComponentType.IMAGE,
                    caption = "Foto från....",
                    image = "startscreen_gps"
                ),
            ),
        ),
        FormScreen(
            components = listOf<FormComponent>(
                FormComponentText(
                    id = "användningTitleScreen3",
                    type = ComponentType.TITLESMALL,
                    text = "Användning av GPS",
                ),
                FormComponentText(
                    id = "användningBodyScreen3",
                    type = ComponentType.BODY,
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                ),
                FormComponentImage(
                    id = "GpsImageScreen3",
                    type = ComponentType.IMAGE,
                    caption = "",
                    image = "startscreen_gps"
                ),
            ),
        ),
        FormScreen(
            components = listOf<FormComponent>(
                FormComponentText(
                    id = "GpsKoordinaterTitleScreen4",
                    type = ComponentType.TITLESMALL,
                    text = "GPS-Koordinater"
                ),
                FormComponentText(
                    id = "tipsBodyScreen4",
                    type = ComponentType.BODY,
                    text = "Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, graphic or web designs. The passage is attributed to an unknown typesetter in the 15th century who is thought to have scrambled parts of Cicero\\'s De Finibus Bonorum et Malorum for use in a type specimen book. \\n\\nIt usually begins with:\n" +
                            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
                ),
            ),
        ),
        FormScreen(
            components = listOf<FormComponent>(
                FormComponentText(
                    id = "Gps-KoordinaterTitleScreen5",
                    type = ComponentType.TITLESMALL,
                    text = "GPS-Koordinater"
                ),
                FormComponentText(
                    id = "Gps-KoordinaterBodyScreen5",
                    type = ComponentType.BODY,
                    text = "Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, graphic or web designs. The passage is attributed to an unknown typesetter in the 15th century who is thought to have scrambled parts of Cicero\\'s De Finibus Bonorum et Malorum for use in a type specimen book. \\n\\nIt usually begins with:\n" +
                            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
                ),
            ),
        ),
        FormScreen(
            components = listOf<FormComponent>(
                FormComponentText(
                    id = "platsTitleScreen6",
                    type = ComponentType.TITLESMALL,
                    text = "Plats",
                ),
                FormComponentText(
                    id = "platsBodyScreen6",
                    type = ComponentType.BODY,
                    text = "Tryck på kartan för att att få ut koordinaterna, du kan välja flera platser.",
                ),
                FormComponentMap(
                    id = "mapScreen6",
                    type = ComponentType.MAPS,
                ),
            ),
        ),
        FormScreen(
            components = listOf<FormComponent>(
                FormComponentText(
                    id = "testaTitleScreen7",
                    type = ComponentType.TITLESMALL,
                    text = "Testa själv"
                ),
                FormComponentText(
                    id = "görsåhärTitleScreen7",
                    type = ComponentType.TITLESMALL,
                    text = "Gör så här"
                ),
                FormComponentText(
                    id = "görSåHärBodyScreen7",
                    type = ComponentType.BODY,
                    text = "1. Lorem ipsum oder Lipsum, wie es manchmal genannt wird, ist ein Blindtext, der beim Layout von Druck-, Grafik- oder Webdesigns verwendet wird. \n\n2. Gießen Sie es vorsichtig bis zu einer Wasserhöhe von etwa 10 cm in das Wasser. Gießen Sie gegen das Hand, damit das Risiko verringert wird, dass Wasser die Poren verstopft, sodass es nicht an der Unterkante des Zylinders ausläuft \n\n3 Messen Sie den Abstand (mm) zwischen der Wasseroberfläche und der Oberkante des Zylinders. Machen Sie eine Markierung an der Kante, an der Sie messen. Neigen Sie ein wenig, damit Sie wissen müssen, wo Sie zuerst gemessen haben, wenn Sie erneut messen. Starten Sie die Zeitmessung, verwenden Sie den Timer in Ihrem Telefon. Messen Sie etwa 30 Minuten lang. \n\n4. Stoppen Sie nach ca. 30 Minuten den Timer. Messen Sie erneut den Abstand (mm) zwischen der Wasseroberfläche und der Oberkante des Zylinders (an der Markierung). \n\nACHTUNG! Die Infiltration kann manchmal sehr schnell gehen, dann stoppen Sie den Timer sofort, wenn das gesamte Wasser eingedrungen ist! \n\nWenn das Eindringen extrem schnell geht, sind Sie möglicherweise über einem großen Riss gelandet. Bewegen Sie dann den Zylinder und wiederholen Sie den Test. \n\nWenn das Eindringen sehr langsam ist k Sie können auch länger als 30 Minuten messen, wenn Sie möchten."),
                FormComponentImage(
                    id = "GpsImageScreen7",
                    type = ComponentType.IMAGE,
                    caption = "Foto från....",
                    image = "startscreen_gps"
                ),
            ),
        ),
        FormScreen(
            components = listOf<FormComponent>(
                FormComponentText(
                    id = "GpsIdagTitleScreen8",
                    type = ComponentType.TITLESMALL,
                    text = "GPS-Koordinater idag"
                ),
                FormComponentText(
                    id = "sammanfattningInfoBodyScreen9",
                    type = ComponentType.BODY,
                    text = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet."),
                ),
        ),
         FormScreen(
            components = listOf<FormComponent>(
                FormComponentText(
                    id = "sammanfattningTitleScreen9",
                    type = ComponentType.TITLESMALL,
                    text = "Sammanfattning",
                ),
                FormComponentText(
                    id = "sammanfattningInfoBodyScreen9",
                    type = ComponentType.BODY,
                    text = "Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, graphic or web designs. The passage is attributed to an unknown typesetter in the 15th century who is thought to have scrambled parts of Cicero\\'s De Finibus Bonorum et Malorum for use in a type specimen book. \\n\\nIt usually begins with:\n" +
                            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                ),
            ),
        ),
        FormScreen(
            components = listOf<FormComponent>(
                FormComponentText(
                    id = "kunskapstestTitleScreen10",
                    type = ComponentType.TITLEBIG,
                    text = "Kunskaps test"
                ),
                FormComponentText(
                    id = "kunskapstestInfoBodyScreen10",
                    type = ComponentType.BODY,
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                ),
                FormComponentText(
                    id = "Fråga1TitleScreen10",
                    type = ComponentType.TITLESMALL,
                    text = "Fråga 1"
                ),
                FormComponentText(
                    id = "Fråga2TitleScreen10",
                    type = ComponentType.TITLESMALL,
                    text = "Fråga 2"
                ), FormComponentText(
                    id = "Fråga3TitleScreen10",
                    type = ComponentType.TITLESMALL,
                    text = "Fråga 3"
                ), FormComponentText(
                    id = "Fråga4TitleScreen10",
                    type = ComponentType.TITLESMALL,
                    text = "Fråga 4"
                ), FormComponentText(
                    id = "Fråga5TitleScreen10",
                    type = ComponentType.TITLESMALL,
                    text = "Fråga 5"
                ), FormComponentText(
                    id = "Fråga6TitleScreen10",
                    type = ComponentType.TITLESMALL,
                    text = "Fråga 6"
                ), FormComponentText(
                    id = "Fråga7TitleScreen10",
                    type = ComponentType.TITLESMALL,
                    text = "Fråga 7"
                ), FormComponentText(
                    id = "Fråga8TitleScreen10",
                    type = ComponentType.TITLESMALL,
                    text = "Fråga 8"
                ), FormComponentText(
                    id = "Fråga9TitleScreen10",
                    type = ComponentType.TITLESMALL,
                    text = "Fråga 9"
                ), FormComponentText(
                    id = "Fråga10TitleScreen10",
                    type = ComponentType.TITLESMALL,
                    text = "Fråga 10"
                ),
            ),
        ),
    )
}