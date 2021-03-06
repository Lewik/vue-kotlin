@file:Suppress("UnsafeCastFromDynamic")

import org.musyozoku.vuekt.*

@JsModule(vue.MODULE)
@JsNonModule
@JsName(vue.CLASS)
external class ExampleVue(options: ComponentOptions<ExampleVue>) : Vue {
    var msg: String
    var rawHtml: String
    var dynamicId: String
    var isButtonDisabled: Boolean
    var number: Int
    var ok: Boolean
    var message: String
    var id: String
    var url: String
}

fun main(args: Array<String>) {
    val vm = ExampleVue(ComponentOptions {
        el = ElementConfig("#example")
        data = Data(json = json {
            msg = "Hi"
            rawHtml = """<input type="text" name="username" value="taro">"""
            dynamicId = "id-0101"
            isButtonDisabled = true
            number = 1
            ok = true
            message = "hello"
            id = "1"
            url = "https://jp.vuejs.org/"
        })
        methods = json {
            this["doSomething"] = {
                val self = thisAs<ExampleVue>()
                self.message = "do something"
            }
        }
    })

    vm.msg = "Oh!"
}