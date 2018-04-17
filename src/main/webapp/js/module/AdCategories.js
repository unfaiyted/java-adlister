var s,
    AdCategoriesLoader = {

        settings: {
            numArticles: 5,
            showCatButton: $(".ad-cat"),
            moreButton: $("#more-button")
        },

        init: function() {
            s = this.settings;
            this.bindUIActions();
        },

        bindUIActions: function() {
            s.showCatButton.on("click", function() {
                AdCategoriesLoader.loadCategories(clickedId);

            });
        },

        loadCategories: function(clickedId) {
            $.ajax({
                url: '/ad/getCat?id=' + clickedID,
                context: document.body
            }).done(function() {
                $( this ).addClass( "done" );
            });

        };





// Display sub-categories
$('.ad-cat').click(function() {
    let id = $(this).attr('data-id');
    $(".sub-cat[data-id='"+ id +"']").append(
        $('<div>').text('name')
    );
});


