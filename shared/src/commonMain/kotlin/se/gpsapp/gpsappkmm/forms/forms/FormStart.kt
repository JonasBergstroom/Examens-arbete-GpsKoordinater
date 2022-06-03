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
                    text = "Tips:\n" +
                            "\nDet kommer ett litet kunskapstest på slutet, så läs noga! "
                ),
                FormComponentImage(
                    id = "GpsImageScreen1",
                    type = ComponentType.IMAGE,
                    caption = "",
                    image = "kunskaps_test"
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
                    text = "GPS har sitt ursprung i Sputnik-eran då forskare kunde spåra satelliten med skiftningar i dess radiosignal, känd som \"Dopplereffekten\". Den amerikanska flottan genomförde satellitnavigeringsexperiment i mitten av 1960-talet för att spåra amerikanska ubåtar som bär kärnvapenmissiler. Med sex satelliter som kretsade runt polerna kunde ubåtar observera satellitförändringarna i Doppler och lokalisera ubåtens plats inom några minuter.\n" +
                            "\n" +
                            "I början av 1970-talet ville försvarsdepartementet (DoD) säkerställa att ett robust, stabilt satellitnavigeringssystem skulle finnas tillgängligt. Genom att omfamna tidigare idéer från marinens forskare, beslutade DoD att använda satelliter för att stödja deras föreslagna navigationssystem. DoD följde sedan upp och lanserade sin första Navigation System with Timing and Ranging (NAVSTAR)-satellit 1978. 24-satellitsystemet blev fullt operativt 1993."
                ),
                FormComponentImage(
                    id = "GpsImageScreen2",
                    type = ComponentType.IMAGE,
                    caption = "",
                    image = "gps_historia"
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
                    image = "anvandning_av_gps"
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
                    text = "Koordinaterna anges i breddgrader och längdgrader Ekvatorn är en latitud som ligger på breddgraden 0° och som delar upp jordklotet i två delar, den norra (N) och den södra (S). Breddgraden för nordpolen är 90° N och för sydpolen 90° S, tillsammans alltså 180°."
                ),
                FormComponentImage(
                    id = "GpsImageScreen4",
                    type = ComponentType.IMAGE,
                    caption = "",
                    image = "gps_koordinater"
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
                    text = "Longitud har en mycket mer komplicerad historia eftersom det är mycket svårare att bestämma utan GPS. Longitud är vinkeln som bildas av en linje från jordens centrum till nollmeridianen vid Greenwich England och en linje från jordens centrum till din plats. (En meridian är en longitudlinje som går från pol till pol.) Eftersom jorden roterar 360 grader varje dag, är det nödvändigt att veta tiden mycket exakt för att relatera solens läge till denna vinkel. Engelsmännen var mycket engagerade i sjöfarten och utvecklingen av en noggrann, sjögående klocka så att de exakt kunde beräkna rätt longitud. De valde att använda Royal Observatory i Greenwich, London, England för sin referensmeridian. (Besök http://millennium-dome.com/info/conference.htm för mer information) Longituden sträcker sig från väst (negativ) 180 grader till öst (positiv) 180 grader.\n" +
                            "\n" +
                            "Latitud och Longitud registreras ofta som grader, minuter och sekunder. Ptolemaios (cirka 150 e.Kr.) delade upp graderna i 60 delar och de delarna i 60 delar. \"I den latinska översättningen av texten blev dessa underavdelningar partes minutae primae och partes minutae secundae varifrån våra \"minuter\" och \"sekunder\" av bågen kommer från.\" (Brown, The Story of Maps, sid 60) Detta kan vara besvärligt så du kan använda decimalgrader. GIS-system måste använda detta enklare format. Den här tabellen nedan visar precisionen för olika enheter i den norra USA-regionen. Observera att en longitud är cirka 69 miles vid ekvatorn och 0 miles vid polerna. Latitud är alltid cirka 69 miles."
                ),
                FormComponentImage(
                    id = "GpsImageScreen5",
                    type = ComponentType.IMAGE,
                    caption = "",
                    image = "gps_koordinaterr"
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
                    text = "Sextant"
                ),
                FormComponentText(
                    id = "görSåHärBodyScreen7",
                    type = ComponentType.BODY,
                    text = "Sextanten har sin främsta användning vid navigation till sjöss, där den oftast används för uppmätning av solens eller andra himlakroppars höjd över horisonten. Både solen och horisonten iakttas genom samma okular och vinkeln mellan dessa avläses på den graderade skalan i nerdelen av instrumentet. Solens höjd över horisonten vid ett visst klockslag och en viss dag på året är alltid densamma. Med hjälp av tabellverk kan man på detta sätt fastställa vilken latitud man befinner sig på. Genom flera mätningar vid bestämda klockslag kan man också fastställa vilken longitud man befinner sig på. Skärningspunkten mellan latitud och longitud ger positionen på jordklotet."),
                FormComponentImage(
                    id = "GpsImageScreen7",
                    type = ComponentType.IMAGE,
                    caption = "",
                    image = "testa_koordinater"
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
                    id = "GpsIdagBodyScreen8",
                    type = ComponentType.BODY,
                    text = "Från gruvdrift till flyg, jordbruk till marin, rekreation till försvar, det finns många applikationer för GPS-teknik. Nuförtiden använder alla från läkare, forskare, bönder, soldater, piloter, vandrare, leveransförare, sjömän, fiskare, avsändare, idrottare och människor från många andra samhällsskikt GPS-system på ett sätt som gör deras arbete mer produktivt, säkrare och lättare.\n" +
                            "\n" +
                            "De tre huvudsakliga industriella användningsområdena för GPS inkluderar precisionsjordbruk, fordon och försvar. I varje exempel löser GPS ett positioneringsproblem. Idag finns det många olika GPS-apparater för att enkelt kunna ta reda på sin position samt koordinater, nu finns också samma funktioner på våra smartphones."),
            FormComponentImage(
                id = "GpsImageScreen8",
                type = ComponentType.IMAGE,
                caption = "",
                image = "gps_idag"
                ),
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
                FormComponentImage(
                    id = "GpsImageScreen9",
                    type = ComponentType.IMAGE,
                    caption = "",
                    image = "gps_sammanfattning"
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
                    text = "Här kommer ett litet kunskapstest för de som vill.",
                ),
                FormComponentText(
                    id = "Fråga1TitleScreen10",
                    type = ComponentType.TITLESMALL,
                    text = "Vad används Gps-koordinater till?"
                ),
                FormComponentText(
                    id = "Fråga2TitleScreen10",
                    type = ComponentType.TITLESMALL,
                    text = "Hur skiljer sig Longitud från Latitud?"
                ), FormComponentText(
                    id = "Fråga3TitleScreen10",
                    type = ComponentType.TITLESMALL,
                    text = "När sköts den första satelliten upp i rymden?"
                ), FormComponentText(
                    id = "Fråga4TitleScreen10",
                    type = ComponentType.TITLESMALL,
                    text = "Kan man ta reda på Gps-koordinater utan modern teknik?"
                ), FormComponentText(
                    id = "Fråga5TitleScreen10",
                    type = ComponentType.TITLESMALL,
                    text = "Hur använts det gammla verktyget för att ta reda på koordinaterna?"
                ),
            ),
        ),
    )
}