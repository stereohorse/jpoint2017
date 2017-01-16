import org.slf4j.LoggerFactory

import static ratpack.groovy.Groovy.ratpack
import static ratpack.jackson.Jackson.json


def reasons = [
    "не тормозит хотя бы",
    "меньше кушает памяти",
    "доки нормальные"
]

def random = new Random()


ratpack {
    handlers {
        get {
            LoggerFactory.getLogger("reasons-api").info("requested reason")

            render(json([value: reasons[random.nextInt(reasons.size())]]))
        }
    }
}