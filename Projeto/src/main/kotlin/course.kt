data class Course(
    override val id:Int,
    override val name: String,
    override val duration: Int,
    override val level: Level,


    ) : TypeStudy() {
    private val lessons: MutableList<Lesson> = mutableListOf()
    override val registeredUsers: MutableList<Student> = mutableListOf()

    override fun register(student: Student){
        registeredUsers.add(student)
    }
    fun addLessons(lesson: Lesson){
        lessons.add(lesson)
    }
}
