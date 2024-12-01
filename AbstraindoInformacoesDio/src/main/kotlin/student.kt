data class  Student(
    val id: Int?,
    val name: String?

){
    private val courses: MutableList<Course> = mutableListOf()
    private val formations: MutableList<Formation> = mutableListOf()

    fun registerCourses(course: Course){
        courses.add(course)
        course.register(this)
    }
    fun registerFormations(formation: Formation){
        formations.add(formation)
        formation.register(this)
    }

}