package app.letsqit.com.compiler.processor

import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.TypeSpec

import java.io.IOException

import javax.annotation.processing.ProcessingEnvironment
import javax.lang.model.type.TypeMirror
import javax.tools.Diagnostic

/**
 * Created by tyln on 19/05/2017.
 */

object EnvironmentUtil {
    private lateinit var processingEnvironment: ProcessingEnvironment
    private var initialize = false


    fun init(environment: ProcessingEnvironment) {
        processingEnvironment = environment
        initialize = true
    }

    fun logError(message: String) {
        if (!initialize) return
        processingEnvironment.messager.printMessage(Diagnostic.Kind.ERROR, message)
    }

    fun logWarning(message: String) {
        if (!initialize) return
        processingEnvironment.messager.printMessage(Diagnostic.Kind.WARNING, message)
    }
    fun savePath() : String {
        if (!initialize) return ""
        val generatedPath = processingEnvironment.options["kapt.kotlin.generated"]
        return generatedPath
                ?.replace("(.*)tmp(/kapt/debug/)kotlinGenerated".toRegex(), "$1generated/source$2")!!
                .replace("kaptKotlin", "kapt")
    }
    @Throws(IOException::class)
    fun generateFile(typeSpec: TypeSpec, packageName: String) {
        JavaFile.builder(packageName, typeSpec)
                .build()
                .writeTo(processingEnvironment.filer)
    }

    fun isSerializable(typeMirror: TypeMirror): Boolean {
        if (!initialize) return false
        val serializable = processingEnvironment.elementUtils
                .getTypeElement("java.io.Serializable").asType()
        return processingEnvironment.typeUtils.isAssignable(typeMirror, serializable)
    }

    fun isParcelable(typeMirror: TypeMirror): Boolean {
        if (!initialize) return false
        val parcelable = processingEnvironment.elementUtils
                .getTypeElement("android.os.Parcelable").asType()
        return processingEnvironment.typeUtils.isAssignable(typeMirror, parcelable)
    }
}// Empty private constructor
