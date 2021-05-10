package deputatecalculation

class Teacher {

    static belongsTo = [department: Department]

    String surname
    String name
    String shortname
    String email
    Date birthdate
    Date lastUpdated
    Date dateCreated
    Department department

    static constraints = {
        surname size: 3..15, blank: false, unique: false
        name size: 3..15, blank: false, unique: false
        shortname size: 2..2, blank: false, unique: false
        email email: true, blank: false
    }

    /**
     *
     * @return Erzeugt die Ansicht der Lehrerliste mit ID, Vorname und Name
     */

    String toString()
    {
        return "${id}${surname}" + "," + "${name}"
    }

}
