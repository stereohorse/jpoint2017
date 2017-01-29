import static ratpack.groovy.Groovy.ratpack
import static ratpack.handling.RequestLogger.ncsa
import static ratpack.jackson.Jackson.json

def names = [
    "JAVA", "HADOOP", "LISP", "ELM", "ПЕЧЕНЬКА", "NODEJS"
]

def random = new Random()


ratpack {
    handlers {
        all(ncsa())

        get("name") {
            def randomName = names[random.nextInt(names.size())]
            render(json([value: randomName]))
        }
    }
}
