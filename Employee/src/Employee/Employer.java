package Employee;

public class Employer {


        private String fullName;
        private String position;
        private String email;
        private int numberPhone;
        private int age;

        public Employer(String fullName, String position, String email, int numberPhone, int age) {
            this.fullName = fullName;
            this.position = position;
            this.email = email;
            this.numberPhone = numberPhone;
            this.age = age;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getNumberPhone() {
            return numberPhone;
        }

        public void setNumberPhone(int numberPhone) {
            this.numberPhone = numberPhone;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }


    }

