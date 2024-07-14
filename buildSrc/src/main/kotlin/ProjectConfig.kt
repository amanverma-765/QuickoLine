import org.gradle.api.JavaVersion


object ProjectConfig {
    const val APP_ID = "org.quickoline"
    const val MIN_SDK = 24
    const val COMPILE_SDK = 34
    const val TARGET_SDK = 34
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0"
    const val IS_MINIFY_ENABLED = false
    const val JVM_TARGET = "17"
    val JAVA_VERSION = JavaVersion.VERSION_17
}