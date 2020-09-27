$(document).ready(function () {
  const getAllMessages = () => {
    $.get('http://localhost:8080/garden-chat-api/getallmessages')
      .done((response) => {
        renderMessages(response)
      })
      .fail((error) => {
        console.log('failed', error)
      })
  }

  const postMessage = () => {
    $.ajax({
      url: 'http://localhost:8080/garden-chat-api/postmessage',
      type: 'POST',
      data: JSON.stringify({
        sender: $('#namefield').val(),
        message: $('#messagefield').val()
      }),
      contentType: 'application/json',
      complete: () => getAllMessages()
    })
  }

  const formattedTimeStamp = (timestamp) => {
    return timestamp !== null
      ? timestamp.replace('T', ' ').substring(0, 16)
      : ''
  }

  const renderMessages = (messages) => {
    messages.reverse()
    $('#messages').empty()

    $.each(messages, (index, msg) => {
      $('#messages').append(
        `<li>
        <img
          class=${index % 2 === 0 ? 'leaf-left' : 'leaf-right'}
          src=${index % 2 === 0 ? 'leaf-left.svg' : 'leaf-right.svg'}
          alt='leaf'
        />
        <p>
          <span class='timestamp'>${formattedTimeStamp(
            msg.timestamp
          )}</span><br>
          <span class='sender'>${msg.sender + ':'}</span>
          <span class='message'>${msg.message}</span>
        </p>
      </li>`
      )
    })

    $('#messagepresenter').html($('#messages'))
  }

  getAllMessages()

  $('form').submit((event) => {
    event.preventDefault()
    postMessage()
    $('#namefield').val('')
    $('#messagefield').val('')
  })
})
