$(document).ready(function() {
  // Khi người dùng nhập vào ô tìm kiếm
  $('#search-input').on('input', function() {
    var keyword = $(this).val();

    // Gọi API để lấy gợi ý
    $.ajax({
      url: 'YOUR_API_URL',
      method: 'GET',
      data: { keyword: keyword },
      success: function(response) {
        showSuggestions(response);
      },
      error: function() {
        // Xử lý lỗi khi gọi API
      }
    });
  });

  // Hiển thị gợi ý
  function showSuggestions(suggestions) {
    var suggestionsList = $('#search-suggestions');
    suggestionsList.empty();

    if (suggestions.length > 0) {
      // Hiển thị gợi ý dưới dạng danh sách
      var ul = $('<ul></ul>');

      for (var i = 0; i < suggestions.length; i++) {
        var li = $('<li>' + suggestions[i] + '</li>');
        ul.append(li);
      }

      suggestionsList.append(ul);
      suggestionsList.show();
    } else {
      suggestionsList.hide();
    }
  }

  // Khi người dùng chọn một gợi ý
  $(document).on('click', '#search-suggestions li', function() {
    var suggestion = $(this).text();
    $('#search-input').val(suggestion);
    $('#search-suggestions').hide();

    // Thực hiện tìm kiếm dựa trên gợi ý được chọn
    performSearch(suggestion);
  });

  // Hàm thực hiện tìm kiếm
  function performSearch(keyword) {
    // Viết code để thực hiện tìm kiếm dựa trên từ khóa
    // ...
  }
});

$(document).ready(function() {
  // ...

  // Khi người dùng chọn một gợi ý
  $(document).on('click', '#search-suggestions li', function() {
    var suggestion = $(this).text();
    $('#search-input').val(suggestion);
    $('#search-suggestions').hide();

    // Thực hiện tìm kiếm dựa trên gợi ý được chọn
    performSearch(suggestion);
  });

  // ...
});
