import com.fasterxml.jackson.databind.ObjectMapper

import static ratpack.groovy.Groovy.ratpack
import static ratpack.handling.RequestLogger.ncsa
import static ratpack.jackson.Jackson.json


def readJsonVal = { String jsonStr ->
    new ObjectMapper().readTree(jsonStr).get("value").toString().replace("\"", "")
}

def namesApiUrl = (System.getenv("NAMES_API_ENDPOINT") + "/name").toURL()
def reasonsApiUrl = (System.getenv("REASONS_API_ENDPOINT") + "/reason").toURL()


ratpack {
    handlers {
        all(ncsa())

        get("holywar") {
            def name1 = readJsonVal namesApiUrl.text
            def name2 = readJsonVal namesApiUrl.text

            def reason = readJsonVal reasonsApiUrl.text

            def holywar = "${name1} круче чем ${name2}, потому что ${reason}".toString()

            render(json([holywar: holywar]))
        }
    }
}
