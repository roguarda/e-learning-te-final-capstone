
    function confirmDelete() {
        let text = "Are you sure you want to Delete this?";
        if (confirm(text) === true) {
            alert("Delete action completed.");
        } else {
            alert("No changes were made.");
        }
    }
