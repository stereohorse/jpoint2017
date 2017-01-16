import static ratpack.groovy.Groovy.ratpack
import static ratpack.handling.RequestLogger.ncsa
import static ratpack.jackson.Jackson.json

def reasons = [
    "не тормозит хотя бы",
    "меньше кушает памяти",
    "доки нормальные"
]

def random = new Random()


ratpack {
    handlers {
        all(ncsa())

        get {
            def randomReason = reasons[random.nextInt(reasons.size())]

            render(json([value: randomReason]))
        }
    }
}