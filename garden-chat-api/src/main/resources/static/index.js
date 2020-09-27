$(document).ready(function () {
  const getAllMessages = () => {
    $.get('http://localhost:8080/garden-chat-api/getallmessages')
      .done((response) => {
        renderMessages(response)
        console.log(response)
      })
      .fail((error) => {
        console.log('failed', error)
      })
  }

  getAllMessages()

  const postMessage = (sender, message) => {
    console.log('Posting message', sender, message)
  }

  $('form').submit((event) => {
    event.preventDefault()
    postMessage($('#namefield').val(), $('#messagefield').val())
    $('#namefield').val() = ''
    $('#messagefield').val() = ''
    renderMessages(getAllMessages())
  })

  const renderMessages = (messages) => {
    $.each(messages, (index, msg) => {
      $('#messages').append(
        `<li>
        <img
          id=${index % 2 === 0 ? 'leaf-left' : 'leaf-right'}
          src=${index % 2 === 0 ? 'leaf-left.svg' : 'leaf-right.svg'}
          alt='leaf'
        />
        <p>
          <span id='sender'>${msg.sender + ':'}</span><br>
          <span class='message'>${msg.message}</span>
        </p>
      </li>`
      )
    })
  }
})
