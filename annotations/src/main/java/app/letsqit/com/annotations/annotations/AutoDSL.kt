package app.letsqit.com.annotations.annotations

import java.lang.annotation.RetentionPolicy
import kotlin.annotation.Retention
import kotlin.annotation.Target

@Target(AnnotationTarget.CLASS) // on class level
@Retention(AnnotationRetention.SOURCE)
@DslMarker
annotation class AutoDSL(val generatedClassName: String = "")