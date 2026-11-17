package university;

public class Identity {

    private String firstName;
    private String lastName;

    public Identity(String surname, String firstname) {
        this.lastName = surname;
        this.firstName = firstname;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Identity)) {
            return false;
        }
        Identity identity = (Identity) o;

        return this.firstName.equals(identity.firstName)
                && this.lastName.equals(identity.lastName);
    }
}