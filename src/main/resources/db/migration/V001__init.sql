------------------------------------------------------
--CREATE ORGANIZATION TABLE--
CREATE TABLE IF NOT EXISTS organization (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    registration_number VARCHAR(50),
    phone VARCHAR(20),
    email VARCHAR(255),
    profile_picture VARCHAR(255),
    foundation_date DATE,
    address_id INT,
    description_id INT
);

--------------------------------------------
--CREATE ADDRESS TABLE--
CREATE TABLE IF NOT EXISTS address (
    id SERIAL PRIMARY KEY,
    street VARCHAR(255),
    city VARCHAR(100),
    state VARCHAR(100),
    country VARCHAR(100),
    postal_code VARCHAR(20),
    organization_id INT REFERENCES organization(id) ON DELETE CASCADE
);

-------------------------------------------
--CREATE DESCRIPTION TABLE--
CREATE TABLE IF NOT EXISTS description (
    id SERIAL PRIMARY KEY,
    website VARCHAR(255),
    social_media VARCHAR(255),
    additional_info TEXT,
    organization_id INT REFERENCES organization(id) ON DELETE CASCADE
);

-----------------------------------------------------
--INDEX ADDRESS AND DESCRIPTION TO ORGANIZATION--
ALTER TABLE organization
    ADD CONSTRAINT fk_address FOREIGN KEY (address_id) REFERENCES address(id) ON DELETE CASCADE,
    ADD CONSTRAINT fk_description FOREIGN KEY (description_id) REFERENCES description(id) ON DELETE CASCADE;

-----------------------------------------------------------------------