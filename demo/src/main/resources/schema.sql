CREATE TABLE IF NOT EXISTS Customer (id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL, name VARCHAR(50));

CREATE TABLE IF NOT EXISTS Customer_Hits 
                        (id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL, 
                        customer_id BIGINT NOT NULL, 
                        hits BIGINT,
                        channel VARCHAR(20));
                        
                        
ALTER TABLE Customer_Hits ADD FOREIGN KEY (customer_id) REFERENCES Customer(id);