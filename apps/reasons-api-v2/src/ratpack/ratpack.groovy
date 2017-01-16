import static ratpack.groovy.Groovy.ratpack
import static ratpack.handling.RequestLogger.ncsa
import static ratpack.jackson.Jackson.json

ratpack {
    handlers {
        all(ncsa())

        get {
            render(json([value: "мы обновили reasons-api!"]))
        }
    }
}
