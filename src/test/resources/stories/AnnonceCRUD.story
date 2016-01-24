Scenario: Add Annonce successfully
 
Given a annonce with email frejsaber@yahoo.fr and password is MotDePasseDeSaber
When I add annonce
Then a annonce with email frejsaber@yahoo.fr should be added into the database

