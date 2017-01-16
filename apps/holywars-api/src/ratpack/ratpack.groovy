import com.fasterxml.jackson.databind.ObjectMapper

import static ratpack.groovy.Groovy.ratpack
import static ratpack.handling.RequestLogger.ncsa
import static ratpack.jackson.Jackson.json


def readJsonVal = { String jsonStr ->
    new ObjectMapper().readTree(jsonStr).get("value").toString().replace("\"", "")
}


ratpack {
    handlers {
        all(ncsa())

        get {
            def name1 = readJsonVal "http://localhost:5051".toURL().text
            def name2 = readJsonVal "http://localhost:5051".toURL().text

            def reason = readJsonVal "http://localhost:5052".toURL().text

            def holywar = "${name1} круче чем ${name2}, потому что ${reason}".toString()

            render(json([holywar: holywar]))
        }
    }
}
