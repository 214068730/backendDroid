package droid_backend.domain.customer;

/**
 * Created by Siraaj on 08/03/2016.
 */
public interface ICustomerEvents {
    public void customerAccountCreated();
    public void viewCustomerAccount(Long customerCode);

}
