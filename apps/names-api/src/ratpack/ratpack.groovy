import org.slf4j.LoggerFactory

import static ratpack.groovy.Groovy.ratpack
import static ratpack.jackson.Jackson.json

def names = [
    "Java", "Hadoop", "Lisp", "Elm", "печеньки", "NodeJS"
]

def random = new Random()


ratpack {
    handlers {
        get {
            LoggerFactory.getLogger("names-api").info("requested name")

            render(json([value: names[random.nextInt(names.size())]]))
        }
    }
}