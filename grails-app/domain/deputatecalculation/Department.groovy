package deputatecalculation

class Department {

    static hasMany = [teachers: Teacher]

    String name

    static constraints = {
        name blank: false, unique: true
    }

    String toString()
    {
        return "${id} ${name}"
    }
}
