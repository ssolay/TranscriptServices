# todo list
* DRY: move `setLablel()` to `config.functions`
* DRY: move `initIsDomestic()` to `config.functions`
* remove `any` property types when we should know the type
* add a reset to the `PreventDoubleSubmitDirective` for when errors come back on submit and the user has to submit again 
* error handling for Ajax calls
* move country/state/zip/phone into a single component? (not sure if this is worth the LOE)
* add animations to hide/show form controls
* does state still turn into a `input[type=text]` field when the country is international?
* add validation check for all form fields above the currently focused field (so if the user jumps to the middle of the form first, errors appear on all the first half fields - but not the second half)
