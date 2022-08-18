$(document).ready(function () {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const curriculaName = urlParams.get('curriculaName');
    const courseName = urlParams.get('courseName');

    if (curriculaName) {
        alert("Curricula "+curriculaName+" created");
    }

    if (courseName) {
        alert("Curricula "+courseName+" created");
    }
});