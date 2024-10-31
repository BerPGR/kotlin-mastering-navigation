package br.com.masteringnavigation

import androidx.annotation.DrawableRes

data class Courses(
    val rating: Float,
    val title: String,
    @DrawableRes val thumbnail: Int,
    val body: String
)

val course1 = Courses(
    4.5f,
    "The Complete Android 13 Course",
    R.drawable.course1,
    "An incredible Android course to master kotlin and java for mobile apps"
)

val course2 = Courses(
    4.5f,
    "The Complete Flutter Course",
    R.drawable.course2,
    "An incredible Android course to master kotlin and java for mobile apps"
)

val course3 = Courses(
    4.5f,
    "The Complete Java Course",
    R.drawable.course3,
    "An incredible Android course to master kotlin and java for mobile apps"
)

val course4 = Courses(
    4.5f,
    "The Complete Kotlin Course",
    R.drawable.course4,
    "An incredible Android course to master kotlin and java for mobile apps"
)

val course5 = Courses(
    4.5f,
    "The Complete VueJS 3 Course",
    R.drawable.course5,
    "An incredible Android course to master kotlin and java for mobile apps"
)

val course6 = Courses(
    4.5f,
    "The Complete NuxtJS 3 Course",
    R.drawable.course6,
    "An incredible Android course to master kotlin and java for mobile apps"
)

val course7 = Courses(
    4.5f,
    "The Complete React Native Course",
    R.drawable.course7,
    "An incredible Android course to master kotlin and java for mobile apps"
)

val course8 = Courses(
    4.5f,
    "The Complete PHP Course",
    R.drawable.course8,
    "An incredible Android course to master kotlin and java for mobile apps"
)

val allCourses = listOf(
    course1,
    course2,
    course3,
    course4,
    course5,
    course6,
    course7,
    course8,
)
