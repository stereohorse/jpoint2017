import static ratpack.groovy.Groovy.ratpack
import static ratpack.handling.RequestLogger.ncsa
import static ratpack.jackson.Jackson.json

def names = [
    "Java", "Hadoop", "Lisp", "Elm", "печенька", "NodeJS"
]

def random = new Random()


ratpack {
    handlers {
        all(ncsa())

        get("name") {
            def randomName = names[random.nextInt(names.size())]

            render(json([value: randomName]))
        }

        get("health") {
            render "OK"
        }
    }
}
