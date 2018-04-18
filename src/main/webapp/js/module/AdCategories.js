let s;

module.exports = {
        test: function() {
          return "Fish are tests";
        },

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

           s.showCatButton.click(function() {
                    let id = $(this).attr("data-id");
                    module.exports.loadCat(id);
           }).on(this);
        },

        loadCat: function (clickedId) {

            $('.sub-cat[data-id="'+clickedId+'"]').toggle().empty();;

            $.getJSON('/ad/getCat?id=' + clickedId, function(data) {

                data.forEach(function (cat) {
                   $('.sub-cat[data-id="'+clickedId+'"]').append(
                       $('<div>').append(
                           $(`<a href="/ads/list?cat=${cat.id}">`).text(cat.title)
                       ));
                })

                console.log(clickedId + " loaded");

            });

            }



    };
