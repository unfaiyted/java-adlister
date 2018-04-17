module.exports = {

        settings: {
            numArticles: 5,
            showCatButton: $(".ad-cat"),
            moreButton: $("#more-button")
        },

        init: function () {
            s = this.settings;
            this.bindUIActions();
        },

        bindUIActions: function () {
            s.showCatButton.on("click", function () {
                AdCategoriesLoader.loadCategories(clickedId);

            });
        },

        loadCategories: function (clickedId) {
            $.ajax({
                url: '/ad/getCat?id=' + clickedID,
                context: document.body
            }).done(function () {
                $(this).addClass("done");
            });

        }


    };
