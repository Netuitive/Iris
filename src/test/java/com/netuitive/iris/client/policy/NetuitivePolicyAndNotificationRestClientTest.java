package com.netuitive.iris.client.policy;

import com.netuitive.iris.client.fixture.NotificationFixtures;
import com.netuitive.iris.client.fixture.PolicyFixtures;
import com.netuitive.iris.client.notification.NetuitiveNotificationRestClient;
import com.netuitive.iris.client.request.policy.NumberOfEventsByPolicyRequest;
import com.netuitive.iris.entity.Policy.Policy;
import com.netuitive.iris.entity.notification.Notification;
import com.netuitive.iris.entity.wrapper.NotificationWrapper;
import com.netuitive.iris.entity.wrapper.NotificationsWrapper;
import com.netuitive.iris.entity.wrapper.PoliciesWrapper;
import com.netuitive.iris.entity.wrapper.PolicyWrapper;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import org.testng.annotations.Test;

/**
 *
 * @author john.king
 */
@Test(groups = "unit")
public class NetuitivePolicyAndNotificationRestClientTest{
    
    private final NetuitiveNotificationRestClient notificationClient = new NetuitiveNotificationRestClient(System.getProperty("username"), System.getProperty("password"));
    
    private final NetuitivePolicyRestClient  policyClient = new NetuitivePolicyRestClient(System.getProperty("username"), System.getProperty("password"));
    
    Long notificationId;
    
    String policyId;
    
    @Test(dependsOnMethods = {"testSendTestNotification"})
    public void testCreateNotification(){
        NotificationWrapper input = new NotificationWrapper();
        input.setNotification(NotificationFixtures.getNotification());
        NotificationWrapper output = notificationClient.create(input);
        assertNotNull(output.getNotification().getId());
        notificationId = output.getNotification().getId();
    }
    
    @Test
    public void testSendTestNotification(){
        NotificationWrapper input = new NotificationWrapper();
        input.setNotification(NotificationFixtures.getNotification());
        String output = notificationClient.sendTestNotification(input);
    }
    
    @Test(dependsOnMethods = {"testCreateNotification"})
    public void testUpdateNotification(){
        NotificationWrapper input = new NotificationWrapper();
        input.setNotification(NotificationFixtures.getUpdatedNotification(notificationId));
        NotificationWrapper output = notificationClient.update(notificationId, input);
        assertEquals(output.getNotification().getProperties().get("bodyTemplate"), "Iris Updated Notification Body");
    }
    
    @Test(dependsOnMethods = {"testCreateNotification", "testUpdateNotification"})
    public void testGetNotification(){
        NotificationWrapper output = notificationClient.get(notificationId);
        assertEquals(output.getNotification().getId(), notificationId);
        assertEquals(output.getNotification().getProperties().get("bodyTemplate"), "Iris Updated Notification Body");
    }
    
    @Test(dependsOnMethods = {"testCreateNotification"})
    public void testGetNotifications(){
        NotificationsWrapper output = notificationClient.list();
        Boolean found = false;
        for(Notification notification : output.getNotifications()){
           if(notification.getId().equals(notificationId)){
               found = true;
               break;
           }
        }
        assertTrue(found);
    }
    
    @Test(dependsOnMethods = {"testCreateNotification"})
    public void testCreatePolicy(){
        PolicyWrapper input = new PolicyWrapper();
        input.setPolicy(PolicyFixtures.getPolicy(notificationId));
        PolicyWrapper output = policyClient.create(input);
        assertNotNull(output.getPolicy().getId());
        policyId = output.getPolicy().getId();
    }
    
    @Test(dependsOnMethods = {"testUpdatePolicy"})
    public void testGetPolicy(){
        PolicyWrapper output = policyClient.get(policyId);
        assertEquals(output.getPolicy().getName(), "Iris Updated Policy Name");
    }
    
    @Test(dependsOnMethods = {"testUpdatePolicy"})
    public void testListPolicies(){
        PoliciesWrapper output = policyClient.list();
        Boolean found = false;
        for(Policy policy: output.getPolicies()){
            if(policy.getName().equals("Iris Updated Policy Name")){
                found = true;
                break;
            }
        }
        assertTrue(found);
    }
    
    @Test(dependsOnMethods = {"testCreatePolicy"})
    public void testGetNumberOfEventsByPolicy(){
        Integer count = policyClient.getNumberOfEventsByPolicy(
                new NumberOfEventsByPolicyRequest(policyId));
        if(count > 0){
            fail();
        }
    }
    
    @Test(dependsOnMethods = {"testCreatePolicy"})
    public void testUpdatePolicy(){
        PolicyWrapper input = new PolicyWrapper();
        input.setPolicy(PolicyFixtures.getUpdatedPolicy(notificationId));
        PolicyWrapper output = policyClient.update(policyId, input);
        assertEquals(output.getPolicy().getName(), "Iris Updated Policy Name");
    }
    
    @Test(dependsOnMethods = {"testGetNumberOfEventsByPolicy", "testListPolicies", "testGetPolicy"})
    public void testDeletePolicy(){
        policyClient.delete(policyId);
    }
    
    @Test(dependsOnMethods = {"testDeletePolicy", "testGetNotification", "testGetNotifications"})
    public void testDeleteNotification(){
        notificationClient.delete(notificationId);
    }
    
}
