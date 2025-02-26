import { Component, ViewChild } from '@angular/core';
import { TaskListComponent } from './components/task-list/task-list.component';
import { Task } from './task.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  @ViewChild(TaskListComponent) taskListComponent!: TaskListComponent;
  selectedTask: Task | null = null;

  refreshTaskList() {
    if (this.taskListComponent) {
      this.taskListComponent.loadTasks();
    }
  }

  onEditRequest(task: Task) {
    this.selectedTask = task;
  }
}
