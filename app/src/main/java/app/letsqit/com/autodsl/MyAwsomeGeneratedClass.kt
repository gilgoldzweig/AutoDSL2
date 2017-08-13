package app.letsqit.com.autodsl

import app.letsqit.com.annotations.annotations.AutoDSL

/**
 * Created by gilgoldzweig on 22/07/2017.
 */
//@AutoDSL
class MyAwesomeGeneratedClass(_name: String, _age: Int) {
    val myAwesomeGeneratedClass: app.letsqit.com.autodsl.RonenGreen =
            app.letsqit.com.autodsl.RonenGreen(name = _name, age = _age)


    fun of(_init: MyAwesomeGeneratedClass.() -> Unit): app.letsqit.com.autodsl.RonenGreen {
        this.apply(_init)
        return myAwesomeGeneratedClass
    }

    fun age(_init: Int.() -> Unit) {
        myAwesomeGeneratedClass.age.apply(_init)
    }
}