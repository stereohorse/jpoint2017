import static ratpack.groovy.Groovy.ratpack
import static ratpack.handling.RequestLogger.ncsa
import static ratpack.jackson.Jackson.json

ratpack {
    handlers {
        all(ncsa())

        get("reason") {
            render(json([value: "мы обновили reasons-api!"]))
        }

        get("health") {
            render "OK"
        }
    }
}
