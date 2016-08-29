package droid_backend.factory;

import droid_backend.domain.address.AddressVO;

/**
 * Created by Siraaj on 08/03/2016.
 */
public class AddressFactory {
    public static AddressVO getAddress(String postalCode, String streetName, String suburb){
        return new AddressVO.AddressBuilder()
                .postalCode(postalCode)
                .streetName(streetName)
                .suburb(suburb)
                .build();
    }
}
