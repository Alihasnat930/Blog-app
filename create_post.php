<?php
include 'db_connect.php';

$title = $_POST['title'];
$content = $_POST['content'];
$author = $_POST['author'];

$sql = "INSERT INTO posts (title, content, author) VALUES ('$title', '$content', '$author')";

if ($conn->query($sql) === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>
