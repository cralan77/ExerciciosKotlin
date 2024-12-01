data class Formation(
    override val id:Int,
    override val name: String,
    override var duration: Int = 0,
    override val level: Level,


    ): TypeStudy(){
        //content of formation

        private val content: MutableList<Module> = mutableListOf()

        override val registeredUsers: MutableList<Student> = mutableListOf()

        override fun register(student: Student){
        registeredUsers.add(student)

    }

    fun addModule(module: Module){
        content.add(module)
        duration += module.duration
    }

}
data class Module(
    val name: String,
    ){
    var duration =0

    //content of module
    private val content: MutableList<Course> = mutableListOf()

    fun addCourse(course: Course){
        content.add(course)
        duration += course.duration


    }
}