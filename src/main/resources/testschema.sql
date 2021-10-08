DROP TABLE IF EXISTS travel_tracker CASCADE;
CREATE TABLE travel_tracker (
    id INT AUTO_INCREMENT,
    travel_method VARCHAR(255) NOT NULL,
	start_destination VARCHAR(255) NOT NULL,
	start_time INT NOT NULL,
    finish_destination VARCHAR(255) NOT NULL,
    finish_time INT NOT NULL,
    PRIMARY KEY (id)
);