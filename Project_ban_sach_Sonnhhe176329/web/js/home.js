
(function ($) {
    "use strict";
    // Initialize
    $(document).ready(function () {
        $(document).on('click', '.add-to-cart', function (e) {
            let currentItemQuantity = $(this).data("quantity");
            let message = "Add to cart successfully";
            if (currentItemQuantity) {
                currentItemQuantity = parseInt(currentItemQuantity);
            }
            if (currentItemQuantity <= 0) {
                message = "This item has been sold out! Please check other item";
                $("#confirmation-notify").html(message);
                $("#modal-add-to-cart").modal("show");
                e.preventDefault()
            }
            console.log()
        });
    });
}(jQuery));

