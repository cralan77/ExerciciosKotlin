abstract class TypeStudy {
    abstract val id: Int
    abstract val name: String
    abstract val duration: Int
    abstract val level: Level
    abstract val registeredUsers: MutableList<Student>
    abstract fun register(student: Student)
}