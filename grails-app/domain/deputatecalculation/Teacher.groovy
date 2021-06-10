package deputatecalculation

class Teacher extends User{

    static belongsTo = [department: Department]

    String abbreviation
    String email
    Date birthdate
    Date lastUpdated
    Date dateCreated
    Department department

    static constraints = {
        surname size: 3..15, nullable: false, unique: false
        abbreviation size: 2..2, nullable: false, unique: false
        email email: true, nullable: false
    }

    /**
     *
     * @return Erzeugt die Ansicht der Lehrerliste mit ID, Vorname und Name
     */

    String toString()
    {
        return "${surname}" + ", " + "${prename}"
    }

}
