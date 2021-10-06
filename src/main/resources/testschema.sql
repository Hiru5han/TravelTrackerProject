DROP TABLE IF EXISTS traveltracker CASCADE;
CREATE TABLE traveltracker (
    id INT AUTO_INCREMENT,
    travelMethod VARCHAR(255) NOT NULL,
	startDestination VARCHAR(255) NOT NULL,
	startTime INT NOT NULL,
    finishDestination VARCHAR(255) NOT NULL,
    finishTime INT NOT NULL,
    PRIMARY KEY (id)
);