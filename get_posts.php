<?php
include 'db_connect.php';

$sql = "SELECT * FROM posts";
$result = $conn->query($sql);

$posts = array();
while($row = $result->fetch_assoc()) {
    $posts[] = $row;
}

echo json_encode($posts);

$conn->close();
?>
