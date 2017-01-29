import static ratpack.groovy.Groovy.ratpack
import static ratpack.handling.RequestLogger.ncsa
import static ratpack.jackson.Jackson.json
import static ru.stereohorse.jpoint2017.Utils.readJsonVal


def namesApiUrl = (System.getenv("NAMES_API_ENDPOINT") + "/name").toURL()


def reasons = [
    "не тормозит хотя бы",
    "меньше кушает памяти",
    "доки нормальные"
]

def random = new Random()


ratpack {
    handlers {
        all(ncsa())

        get("holywar") {
            def name1 = readJsonVal namesApiUrl.text
            def name2 = readJsonVal namesApiUrl.text

            def reason = reasons[random.nextInt(reasons.size())]

            def holywar = "${name1} круче чем ${name2}, потому что ${reason}".toString()

            render(json([holywar: holywar]))
        }
    }
}
