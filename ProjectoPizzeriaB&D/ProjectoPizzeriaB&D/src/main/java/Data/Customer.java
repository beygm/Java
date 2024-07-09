package Data;


public class Customer {
    
    public class Cliente {
    private int idCustomer;
    private String name;
    private String address;
    private String email;
    private String phoneNumber;

        public Cliente(int idCustomer, String name, String address, String email, String phoneNumber) {
            this.idCustomer = idCustomer;
            this.name = name;
            this.address = address;
            this.email = email;
            this.phoneNumber = phoneNumber;
        }

        public int getIdCustomer() {
            return idCustomer;
        }

        public void setIdCustomer(int idCustomer) {
            this.idCustomer = idCustomer;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
        
    }
}
